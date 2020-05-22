override fun getItem(position: Int): Fragment {

    return when(position){
        0 -> input
        1 -> history
        2 -> chart
        else -> throw NullPointerException()
    }
}