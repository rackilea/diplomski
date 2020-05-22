PalletRack palletRack1 = new PalletRack(root, SHAPE_DRAW_2D3D, true, 760.0, 90.0, 0.0, 160.0, 14.0, 14.0, 10.0, 0.0, PALLET_RACK_TWO_PALLET_RACKS, PALLET_RACK_NO_DIRECTION,
            11.0, 40.0, 16.0, 10, 2, 1, cyan, maroon, 100 );

PalletRack palletRack = new PalletRack(root, SHAPE_DRAW_2D3D, true, 760.0, 240.0, 0.0, 160.0, 14.0, 14.0, 10.0, 0.0, PALLET_RACK_TWO_PALLET_RACKS, PALLET_RACK_NO_DIRECTION,
            11.0, 40.0, 16.0, 10, 3, 2, cyan, maroon, 100 );

root.set_palletRack(palletRack);
root.set_palletRack1(palletRack1);

root.network.add(root.palletRack);
root.network.add(root.palletRack1);