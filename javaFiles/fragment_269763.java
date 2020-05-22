function EnglishSpeaker() {}
EnglishSpeaker.prototype.greet = function() { return 'hello'; };

function SpanishSpeaker() {}
SpanishSpeaker.prototype.greet = function() { return 'hola'; };

function Me() {}
Me.prototype = EnglishSpeaker.prototype;

var me = new Me();
me instanceof EnglishSpeaker; // true
me.greet(); // 'hello'

Me.prototype = SpanishSpeaker.prototype;
me = new Me();
me instanceof EnglishSpeaker; // false
me instanceof SpanishSpeaker; // true
me.greet(); // 'hola'