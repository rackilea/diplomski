class RestController {

  void methodA() {
    new Thread() {
      service.methodA();
    }.start();
  }

  void methodB() {
    new Thread() {
      service.methodB();
    }.start();
  }

  void methodD() {
    new Thread() {
      service.methodA();
      service.methodB();
    }.start();
  }

}

class Service {

  void methodA() {
    // some hard work
  }

  void methodB() {
    // some hard work
  }

}