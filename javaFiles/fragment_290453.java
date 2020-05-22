public class StoryController {

    public static Result allStories(){
        List<Story> stories = new Model.Finder<String , Story>(String.class, Story.class).all();
        return Results.ok(Json.toJson(stories));
    }

    public static Result getStory(String storyId){
        Story story = new Model.Finder<String, Story>(String.class, Story.class).byId(storyId);
        if(story == null){
            return Results.notFound("No story found with storyId " + storyId);
        }
        return Results.ok(Json.toJson(story));
    }
}