private fun multiplyByTwo(number: Int) {
    mathApi.multiplyByTwo(number).subscribe {
        if (it < Integer.MAX_VALUE) { // When you run out of data.
            multiplyByTwo(it)
        }
    }
}