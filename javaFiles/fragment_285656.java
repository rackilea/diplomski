protocol Subscribable: class {
    associatedtype DataType

    func onNext(_ data: DataType)
    func onCompleted()
    func onError()
}

extension Subscribable where Self: BaseMvpView {
    func onNext(_ data: DataType) {
        hideLoading()
        print("super next")
    }

    func onCompleted() {
        hideLoading()
        print("super completed")
    }

    func onError() {
        hideLoading()
        print("super error")
        if let serviceError = error as? ServiceError {
            print("Service error: \(serviceError.errorDescription ?? "Something wrong")")
        }
    }
}

// BaseMvpView will get all above methos implemented, child classes can implement their own version.
extension BaseMvpView: Subscribable { 
    typealias DataType = DataTypeThatIsUsedByMvpView
}

// the subscriber function got simplifier as it no longer needs
// the callback parameters, as those are not part of the protocol
// this also makes the function more flexible as it's not tied to a
// concrete class
func baseSubscriber<S: Subscribable, T>(_ subscribable: S) -> (RxSwift.Event<T>) -> Void where S.DataType == T {
    return { [weak subscribable] event in
        switch event {
        case let .next(element):
            subscribable?.onNext(element)
        case .completed:
           subscribable.onCompleted()
        case let .error(error):
            subscribable.onError(error)
        }
    }
}