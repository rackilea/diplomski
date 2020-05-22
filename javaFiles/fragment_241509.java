ArrayList<Disposable> disposables = new ArrayList<Disposable>();
Foo myFoo = new Foo();
disposables.add(myFoo);

//game is running
//....
//
for(Disposable d : myFoo)
{
    d.dispose();
}
//end of the main