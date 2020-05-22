class Page{
    <T extends Page> T conditionalAction( T pageObject ){
        return pageObject;
    }
}
class Page1 extends Page{
    Page1 action1(){ return this; }
}
class Page2 extends Page{
    Page2 action2(){ return this; }
}