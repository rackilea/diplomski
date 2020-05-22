a = true;
b = false;

if a && b {
  log "1 :: a=" + a +", b=" + b;
}
else if a || b {
  log "2 :: a=" + a +", b=" + b;
}
else {
  log "3 :: a=" + a +", b=" + b;
}

log "Done!";