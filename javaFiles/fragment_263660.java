const regex = /^(https?|ftp|file):\/\/(www.)?(.*?)\.(mp3)$/gm;
const str = `https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3
http://soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3
http://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3
ftp://soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3
file://localhost/examples/mp3/SoundHelix-Song-1.mp3
file://localhost/examples/mp3/SoundHelix-Song-1.wav
file://localhost/examples/mp3/SoundHelix-Song-1.avi
file://localhost/examples/mp3/SoundHelix-Song-1.m4a`;
let m;

while ((m = regex.exec(str)) !== null) {
    // This is necessary to avoid infinite loops with zero-width matches
    if (m.index === regex.lastIndex) {
        regex.lastIndex++;
    }
    
    // The result can be accessed through the `m`-variable.
    m.forEach((match, groupIndex) => {
        console.log(`Found match, group ${groupIndex}: ${match}`);
    });
}