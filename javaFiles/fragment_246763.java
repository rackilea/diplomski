abstract class Car{
    abstract int getDoorCount();
    abstract int getWindowCount();
    abstract int getPrice();
}

class Honda extends Car{

    @Override
    int getDoorCount() {
        return 2;
    }

    @Override
    int getWindowCount() {
        return 0;
    }

    @Override
    int getPrice() {
        return 1000;
    }
}

class Nissan extends Car{

    @Override
    int getDoorCount() {
        return 4;
    }

    @Override
    int getWindowCount() {
        return 0;
    }

    @Override
    int getPrice() {
        return 2000;
    }
}

class Subaru extends Car{

    @Override
    int getDoorCount() {
        return 1;
    }

    @Override
    int getWindowCount() {
        return 1;
    }

    @Override
    int getPrice() {
        return 3000;
    }
}