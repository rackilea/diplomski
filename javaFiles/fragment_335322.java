class Binding(val listener: Listener) {

    @BindingAdapter("board")
    fun setBoard(view: TextView, board: Board) {
        view.setText(board.name)
        view.setOnClickListener {
            listener.onBoardClicked(board)
        }
    }

    @BindingAdapter("topic")
    fun setTopic(view: TextView, topic: Topic) {
        view.setText(topic.name)
        view.setOnClickListener {
            listener.onTopicClicked(topic)
        }
    }
}