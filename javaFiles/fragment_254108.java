//package your.package.utils;

public interface ICallback<T>{
     void onSucess(T result);
     void onError(String error, int code);
}