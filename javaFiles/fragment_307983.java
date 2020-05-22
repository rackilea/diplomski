switch (args[0]) {
    case “bark”:
         if(args.length > 1) Dogs.bark(args[1]);
         else Dogs.bark();
         break;
    default:
         break;
}