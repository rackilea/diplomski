//unlike photo
public static void unlike(Photo photo, User user) {
    try {
        likes.get(photo.remove(user));
    }
    catch (NullPointerException e) {

    }
}