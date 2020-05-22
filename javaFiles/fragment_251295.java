import * as app from "tns-core-modules/application";
const androidApp = app.android;

if (androidApp.foregroundActivity === androidApp.startActivity) {
    ////console.log("We are currently in the main (start) activity of the application");
}