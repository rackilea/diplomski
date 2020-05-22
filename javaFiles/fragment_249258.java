public Bmoll(int startX, int startY)
    {
        this.fromX = startX;
        this.fromY = startY;
        this.inverted = false;
        this.staff = Staff.getActiveStaff();
        this.bmoll = GuiHelper.getImage(B_MOLL_FILE);
    }