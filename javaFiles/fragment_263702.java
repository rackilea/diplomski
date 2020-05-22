abstract class BaseFirestoreAdapter<T : BaseFirestoreAdapter.DataInterface, VH : RecyclerView.ViewHolder>(val filteredProperty: (T) -> CharSequence) : RecyclerView.Adapter<VH>(), Filterable
{

    var sourceList: MutableList<T> = ArrayList()

    // ...

    override fun performFiltering(keyword: CharSequence): FilterResults {

        val keywordRegex = keyword.toString().toRegex(setOf(RegexOption.IGNORE_CASE, RegexOption.LITERAL))

        filteredList = sourceList.filter {
                keywordRegex.containsMatchIn(Normalizer.normalize(filteredProperty(it), Normalizer.Form.NFD).replace("[^\\p{ASCII}]".toRegex(RegexOption.IGNORE_CASE), ""))
        }

        results.values = filteredList.sortedWith(orderComparator)
        results.count = filteredList.size
    }

    ...
}