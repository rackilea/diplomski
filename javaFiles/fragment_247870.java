@for((project, index) <- projects.zipWithIndex) {
    <h3>@project.name</h3>
    <div>
    @form(routes.Application.updateProject(project.getId), 'class -> "ajaxForm") {
        @defining(projectForm.bind(scala.collection.mutable.Map(
            "name" -> project.name,
            "description" -> project.description))) { form =>
            @inputText(form("name"), 'id -> ("name" + index))
            @textarea(form("description"), 'id -> ("description" + index))
            <input type="submit" value="Update"/>
        }
    }
    </div>
}