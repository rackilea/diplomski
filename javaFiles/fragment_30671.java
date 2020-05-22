ScanStrategy strategy;
switch(datatypeInt){
  case 2:
    strategy = new Simple3DDataScanner();
    break;
  case 1:
  default:
    strategy = new Simple2DDataScanner();
}
Scan scan = new Scan(strategy);