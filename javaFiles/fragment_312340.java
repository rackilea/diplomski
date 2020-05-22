private Control createFxControl() {

    // create a clock using the enzo library from https://github.com/HanSolo/Enzo
    Clock clock = ClockBuilder.create()
            // .prefSize(400, 400)
            .design(Clock.Design.DB)
            .running(true)
            .text("Berlin")
            .autoNightMode(true)
            .build();


    return clock;
}