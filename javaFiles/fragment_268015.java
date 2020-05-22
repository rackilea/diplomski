function draw_card(card) {
  var $card = $("<div/>");
  $card.text(card.label);
  $card.addClass('card');
  $card.css({
    'left': card.x,
    'top': card.y,
    'z-index': card.z
  });
  $card.appendTo($('#my_canvas'));
  card.rect = $card;
  // last row doesn't actually have children
  if (card.left_child_index) {
    $card.mouseover(function() {
      cards[card.left_child_index].rect.addClass("child");
      cards[card.right_child_index].rect.addClass("child");
    });
    $card.mouseout(function() {
      cards[card.left_child_index].rect.removeClass("child");
      cards[card.right_child_index].rect.removeClass("child");
    });
  }
}

function make_card(label, z) {
  return {
    label: label,
    z: z
  };
}

var CARD_X_PADDING = 4;
var CARD_X_SPACING = 50;
var CARD_Y_SPACING = 45;

var x_row_base = 250; // You used 800 here
var y = 0;
var cards = Array(28);

// Set up card pyramid
for (var i = 0, row = 0; i < cards.length; row++) {
  var x = x_row_base;
  for (var col = 0; col < row; i++, col++) {
    cards[i] = make_card(i, row);
    // set x and y position
    cards[i].x = x;
    cards[i].y = y;
    // create links to "child" cards in next row
    if (i < 21) {
      cards[i].left_child_index = i + row;
      cards[i].right_child_index = i + row + 1;
    }
    // display the card
    draw_card(cards[i]);
    x += CARD_X_SPACING + CARD_X_PADDING;
  }
  y += CARD_Y_SPACING;
  x_row_base -= (CARD_X_SPACING + CARD_X_PADDING) / 2;
}