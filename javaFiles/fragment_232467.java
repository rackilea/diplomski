Test test = new Test()
{{
    SetA("test");
    SetB(new OtherClass()
    {{
        SetSome("Some");
        SetAgain("Again");
    }});
}};