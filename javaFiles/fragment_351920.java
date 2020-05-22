class TaskResponse {
    private Task task;
}

class Task {
    private Long id;
    private List<Link> links;
}

class Link {
    String href;
}