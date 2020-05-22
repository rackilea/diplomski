public class Observable<U> {

        private List<Observer<Observable<U>, U>> _observers =
                new ArrayList<Observer<Observable<U>, U>>();

        public void addObserver(Observer<Observable<U>, U> obs) {
            if (obs == null) {
                throw new IllegalArgumentException();
            }
            if (_observers.contains(obs)) {
               return;
            }
            _observers.add(obs);            }

        public void notifyObservers(U data) {
            for (Observer<? super Observable<U>, U> obs : _observers) {
                obs.atualizar(this, data);
            }
        }
    }

    interface Observer<T, U> {
        public void atualizar(T entity, U arg);
    }