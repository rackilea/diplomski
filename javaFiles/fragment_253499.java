override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    when (parent?.id) {
        R.id.provinceSpinner -> {
            val provinceName = provinceSpinner?.getItemAtPosition(position)

            // get cities here using provinceName
            val cities = ...

            // Fill with cities
            cityAdapter?.clear()
            cityAdapter?.addAll(cities)
            cityAdapter?.notifyDataSetChanged()
        }
    }
}