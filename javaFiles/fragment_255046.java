// This is creating a mess
Element player = document.createElement("player");
Element playerName = document.createElement("name");
Element moneyAmount = document.createElement("money");
playerName.appendChild(document.createTextNode(name));
playerName.appendChild(document.createTextNode(String.valueOf(money)));
player.appendChild(playerName);