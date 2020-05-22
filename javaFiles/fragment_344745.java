import com.fasterxml.jackson.annotation.JsonAutoDetect;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.fasterxml.jackson.annotation.JsonView;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    class PersonResponse {

        @JsonView(PersonResponseViews.Person.class)
        String name;

        @JsonView(PersonResponseViews.Person.class)
        Profile profile;

        @JsonView({
            PersonResponseViews.Person.class,
            PersonResponseViews.Profile.class
        })
        Error error;

        @JsonProperty("id")
        @JsonView(PersonResponseViews.Profile.class)
        int getProfileId() {
            int id = 0;

            if (profile != null) {
                id = profile.id;
            }

            return id;
        }

        @JsonView({
            PersonResponseViews.Person.class,
            PersonResponseViews.Profile.class
        })
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
        static class Error {

            String message;
            int code;
        }

        @JsonView(PersonResponseViews.Person.class)
        @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
        static class Profile {
            int id;
        }
    }