@import "../valo/valo.scss";

@mixin mytheme {

    // Insert your own theme rules here
    .v-caption-mystyle {
        .v-captiontext {
            font-size: 13px;
            font-weight: bold;
            color: red;
        }
    }

    @include valo;
}