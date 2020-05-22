class EmptyStream {
    map() {
        return this;
    }

    filter() {
        return this;
    }

    take() {
        return [];
    }
}

class Stream extends EmptyStream {
    constructor(value, next) {
        super();
        this._next = next;
        this.value = value;
    }

    /**
     * This prevents the value to be computed more than once
     * @returns {EmptyStream|Stream}
     */
    next() {
        if( ! (this._next instanceof EmptyStream) ) {
            this._next = this._next();
        }
        return this._next;
    }

    map(fn) {
        return new Stream(fn(this.value), () => this.next().map(fn));
    }

    filter(fn) {
        return fn(this.value) ?
            new Stream(this.value, () => this.next().filter(fn)) :
            this.next().filter(fn);
    }

    take(n) {
        return n == 0 ? [] : [this.value, ...this.next().take(n && n - 1)];
    }

    static range(from, to, step = 1) {
        if (to !== undefined && ( step > 0 && from > to || step < 0 && from < to )) {
            return Stream.emptyStream;
        }
        return new Stream(from, () => Stream.range(from + step, to, step));
    }
}

Stream.emptyStream = new EmptyStream();