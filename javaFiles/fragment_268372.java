//constructor method
public Group(int total_users) {
    max_users = total_users;//max_users equals value passed to class with new
    user_count = 0;
    directory = new String[max_users]; // removed the String[] type, so you are now referencing the class variable
}