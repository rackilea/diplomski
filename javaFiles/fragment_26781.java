class UserParam {
    String fristName;
    String lastName;
}

class CountryParam {
    String name;
}

interface CRUD<T> {
    int create(T param);
}

class User implements CRUD<UserParam> {
    int create(UserParam param) {
        // do something based on received param of type UserParam
    }
}

class Country implements CRUD<CountryParam> {
    int create(CountryParam param) {
        // do something based on received param of type CountryParam
    }
}