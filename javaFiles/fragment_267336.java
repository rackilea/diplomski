button.setOnClickListener(object : View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(this@MainActivity, "Hello!", Toast.LENGTH_SHORT).show();
    }
})

// Or in shorter way:
frame_layout.setOnClickListener {
    Toast.makeText(this@MainActivity, "Hello!", Toast.LENGTH_SHORT).show();
}