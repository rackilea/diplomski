static void show(@NonNull Context context, @NonNull Arri<Mylist> notification) {

            ....

        String strings = "text1,text2,text3,text4,...";
        String[] stringarray = strings.split(",");

        for(String name : stringarray){
          if (notifyMe(name, notification)) {
               break;
            }
        }
    }

    private static boolean notifyMe(String text, @NonNull Arri<Mylist> notification) {
        if (notification.loadr().project().toString().toLowerCase().contains(text.toLowerCase())) {
            return true;
        }
        return false;
    }