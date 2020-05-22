class Task (taskDict: HashMap<String, Any>) {

    var id: String = ""
    var title: String = ""

    init {
        // Task
        val taskObject = taskDict["task"] as HashMap<String, Any>?

        if (taskObject != null) {
            val id = taskObject["_id"] as String? ?: ""
            val title = taskObject["_object"] as String? ?: ""

            this.id = id
            this.title = title
        }

    }
}