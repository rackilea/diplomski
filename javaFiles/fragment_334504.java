override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    (activity as BaseActivity).run {

        availabilitiesSwitch?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                showShifts()
            }
        }
    }
}