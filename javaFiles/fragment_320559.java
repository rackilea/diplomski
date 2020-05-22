@NgModule({
imports:      [
    ProductsModule,
    BrowserModule,
    HttpModule,
    FormsModule,
    PortalModule,
    SidebarModule,
    NavbarModule,
    FooterModule,
    RouterModule.forRoot([]),
],
declarations: [ AppComponent, PortalComponent ],
bootstrap:    [ AppComponent ],
providers:      [ Logger, { provide: LocationStrategy, useClass: HashLocationStrategy } ],
})
export class AppModule { }