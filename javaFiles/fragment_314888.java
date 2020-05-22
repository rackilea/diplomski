$.ajax({
    type: "POST",
    url: "vocabulary/createVocabulary",
    contentType : 'application/json; charset=utf-8',
    data: JSON.stringify({"vocabularyName" : "a",
    "vocabularyDescription" : "b"}),


@Controller
@RequestMapping(path="vocabulary")
public class VocabularyController {

@RequestMapping (path = "createVocabulary", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE}
@ResponseBody String createVocabulary(@RequestBody VocabularyDTO vocabularyDTO){
    return "Success";
  }
}