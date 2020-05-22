func customSubscriber<T>(mvpView: MvpView, presenter: BasePresenter) -> (RxSwift.Event<T>) -> Void {
    return { [weak mvpView, weak presenter] event in
        switch event {
        case let .next(element):
            print("Received \(element)")

        case .completed:
             print("Done")

        case let .error(error):
            if let serviceError = error as? ServiceError {
                print("Service error: \(serviceError)")
            } else {
                print("Some error: \(error)")
            }
        }
    }
}