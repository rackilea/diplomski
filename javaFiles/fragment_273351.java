class MainFragment : Fragment(R.layout.main_fragment) {

//...

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InputButton.setOnClickListener {
            InputButton.setOnClickListener(this)
            sendMessage()
        }
    }
}