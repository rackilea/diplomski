binding.seekbarConstrast.setOnSeekBarChangeListener(object : OnSeekBarSimpleChangeListener() {

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        mainViewModel.adjustConstrast(
            ProcessUtils.seek2param(
                seekBar!!.max, 0f, 4f, seekBar.progress
            )
        )
    }
})