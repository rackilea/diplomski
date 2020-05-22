switch(weaponChoice + "|" + computerChoice)
{
    case "Rock|Scissors":
    case "Scissors|Paper":
    case "Paper|Rock":
        System.out.println("You won!");
        userScore++;
        break;
    case "Rock|Paper":
    case "Paper|Scissors":
    case "Scissors|Rock":
        System.out.println("You lost!");
        compScore++;
        break;
    default:
        System.out.println("It's a draw!");
        ties++;
}