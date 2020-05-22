@import "../valo/valo.scss";

@mixin mytheme {
  @include valo;

  /* An actual theme rule */
  .v-button {
    color: blue;
  }
}