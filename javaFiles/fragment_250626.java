@(gesturesListFromMyController: List[GestureClassEntity])

@for(gesture <- gesturesListFromMyController){
    <div class="gesture-item">
        <h2>@gesture.name</h2>
        <p>@gesture.description</p>
    </div>
}