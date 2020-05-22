class OpticalDrive {

}

class DVDDrive extends OpticalDrive {
    protected int speed = 5;
}

class CDDrive extends OpticalDrive {
    protected int speed = 10;
}

class ComboDrive extends DVDDrive, CDDrive {
    ComboDrive() {
        System.out.println(super.speed); 
        super.speed = 15;
    }
}