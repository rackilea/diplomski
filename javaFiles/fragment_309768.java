package com.yourname.player;
public interface Player extends Oberservable<PlayerObserver>

package com.yourname.gaming;
public class Battlefield implements PlayerObserver 

package com.yourname.player;
public interface PlayerObserver {
     void notify(Player player);
}

package com.yourname.core;
public interface Oberservable<T> {
     void addObserver(T observer);
}