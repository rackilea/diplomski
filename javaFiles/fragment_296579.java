class AbstractController{
    abstract getDomainClass();   
    def show(Long id){
       log.info(getDomainClass())
    }
    def entity = getDomainClass().get(id) 
}

class NewsController extends AbstractController {
    def getDomainClass(){
        return News
    }
 }