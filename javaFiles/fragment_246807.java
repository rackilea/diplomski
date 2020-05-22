interface KeyMapperService {
    interface Add {
         class Success implements Add {
            Success(String key, String link){}
        }

        class AlreadyExist implements Add {
             AlreadyExist(String key){}
        }
    }

    interface Get {
        class Link implements Get{
            Link(String link){}
        }

        class NotFound implements Get{
            NotFound(String key){}
        }
    }

    public Add add(String key, String link);

    public Get getLink(String key);
}