01 boolean strike;
02 do {
03     strike = false;
04     for (EnemyShip tempEnemy: EList) {
05         if (x==tempEnemy.x && y==tempEnemy.y) {
06             strike = true;
07             EList.remove(tempEnemy);
08             break; // We need to break here, because the line07 maybe made
09             // the list empty and cause a ConcurrentModificationException.
10             // Also: tempEnemy is not longer part of the list "EList" so we have a invalid state.
11         }
12     } 
13 } while (strike);