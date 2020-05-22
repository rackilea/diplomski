@Test
public void handlerFetchesSomethingOnUpdate()
{
    final Handler handler = new Handler();

    new NonStrictExpectations(handler) {{
        handler.fetch(); result = response;
    }};

    handler.update();
}