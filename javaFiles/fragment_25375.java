// Use function like this:
// function yourFunction(parameter1, parameter2, ...) {
// or use document DOMContentLoaded event listener:
function yourFunction(a, b, k) {
    try {
        if (a <= 1 || b <= a) {
            error("Error: must have 1 < A < B");
        }
        if (k <= 0 || k % 2 == 0) {
            error("Error: K must be a positive odd number");
        }
        console.log(solution(a, b, k));
    } catch(e) {
        error("Usage: EvaluateDivisors A B K");
    }
};

function solution(a, b, k) {  
    if (prime(k)) {
        return primeSolution(a, b, k);
    }
    var result = 0;

    for (var n = Math.sqrt(a); n * n <= b; n++) {

        var divisors = 3;

        for (var m = 2; m < n && divisors <= k; m++) {
            if (n * n % m == 0) {
                divisors += 2;
            }
        }
        if (divisors == k) {
            result++;
        }
    }
    return result;
}

function primeSolution(a, b, k) {
    var result = 0;

    var n = 2;
    while (Math.pow(n, k - 1) < a) {
        n++;
    }
    while (Math.pow(n, k - 1) <= b) {
        if (prime(n++)) {
            result++;
        }
    }
    return result;
}


function prime(n) {
    for (var m = 2; m <= Math.sqrt(n); m++) {
        if (n % m == 0) {
            return false;
        }
    }
    return true;
}

function error(message) {
    console.log(message);
}