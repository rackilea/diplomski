switch (user.getUserType()) {
    case COUNTERA:
        MyHttpSessionListener.incA();
        break;

    case COUNTERB:
        MyHttpSessionListener.incB();
        break;
}