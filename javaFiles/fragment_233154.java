@NgModule({
    declarations: [declarations],
    imports: [imports],
    providers:
    [
        {provide: XSRFStrategy, useFactory: xsrfFactory}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}

export function xsrfFactory() {
    return new CookieXSRFStrategy('XSRF-TOKEN', 'XSRF-TOKEN');
}