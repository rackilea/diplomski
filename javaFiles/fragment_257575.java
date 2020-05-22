class Controller{
    Queue<UIEvent> events;

    void setupUI(){
        button.addEventListener( new EventListener(){
             Model.this.events.add(new TappedButtonEvent());
        });
    }

    UIEvent dequeueEvent(){
        if(events.size() > 0){
            return events.pop()
        }
        return null;
    }

    }

    class Model{

    public void loop(){
        while (!gameFinished) {
             UIEvent in = input.dequeueEvent();
             if(in != null){
                  performAction(in);
             }
        }
    }
    }